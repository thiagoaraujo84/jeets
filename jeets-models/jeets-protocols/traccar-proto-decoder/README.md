Traccar Proto Decoder for Traccar GTS
===============

The Book Chapter 7.5 'Traccar Proto Decoder' describes how to add a Protobuffer Decoder 
for the jeets-pu-traccar Entities and the pu-protocols with the Traccar.java Decoder.
The Decoder has been updated to Traccar 4.2 and you can add the Decoder 
to your Traccar installation in four steps:


copy two Java files from this directory 
---- 

	org.traccar.protocol.ProtobufferProtocol.java
	org.traccar.protocol.ProtobufferDecoder.java

to the org.traccar.protocol package directory in Traccar.
 
Note that the files are not compiled in the JeeTS repository
as they depend on many Traccar classes. 
Please check for errors in the Traccar environment when adding them.

The actual implementation of the Protobuffer Decoder 
can be found in the method

	Object decode(Channel channel, SocketAddress remoteAddress, Object msg)

and should be easy to adopt to your needs or to debug integration problems.


add jeets-protocols to pom.xml
--- 

See the example file traccar.pom.xml in this directory 
where to place the jeets-protocols dependency and version.
If you introduce the dependency as the last one
you will not overrule traccar's dependencies.
The file is only a portion of Traccar's pom.xml and not functional.

	<groupId>org.traccar</groupId>
	<artifactId>traccar</artifactId>
	<version>4.1-SNAPSHOT</version>
	
	<dependencies>
		<dependency>
			<groupId>junit</groupId>
			<artifactId>junit</artifactId>
			<version>4.12</version>
			<scope>test</scope>
		</dependency>
	
			...
	
		<!-- place additional protocols at end -->
		<dependency>
			<groupId>org.jeets</groupId>
			<artifactId>jeets-protocols</artifactId>
			<version>1.2-RC</version>
		</dependency>
	<dependencies>

Also note Traccar's release version at the beginning of the pom file.

The new dependency will raise a slf4j multiple binding problem
but this does not harm the actual binding:

	SLF4J: Class path contains multiple SLF4J bindings.
	SLF4J: Found binding in ...
	SLF4J: Found binding in ...
	SLF4J: See http://www.slf4j.org/codes.html#multiple_bindings for an explanation.
	SLF4J: Actual binding is of type [org.slf4j.impl.JDK14LoggerFactory]

You can optimize the protocols import by excluding the Hiberate JPA implementation 
which is not applied in Traccar and exclude the logging conflict with.

		<dependency>
			<groupId>org.jeets</groupId>
			<artifactId>jeets-protocols</artifactId>
            <version>1.2-RC</version>
            <exclusions>
            	<exclusion>
            		<groupId>org.hibernate</groupId>
            		<artifactId>hibernate-core</artifactId>
            	</exclusion>
            	<exclusion>
            		<groupId>org.slf4j</groupId>
            		<artifactId>slf4j-log4j12</artifactId>
            	</exclusion>
            </exclusions>
		</dependency>


add protocol to Traccar's traccar.xml file
--

Add the line

	<entry key='protobuffer.port'>5200</entry>
	            -----------

Note that the protocol name is derived from the protocol's class name

	ProtobufferProtocol -> protocol: protobuffer
	-----------                      -----------

and has to match the entry of the configuration file.


register the unique Id you are using in the client software
--

If your Traccar installation compiles successfully 
you are prepared to receive Device protobuffers with Traccar
and you can send messages with the jeets-tracker or jeets-player.
The default device for tracker tests is 'pb.device' and you
can use the Traccar frontend to create a new device
with name 'jeets-tracker' and uniqueId 'pb.device' 

Update, refresh, compile or deploy Traccar as you usually do
and make sure the new protobuffer protocol is bound to its port.
Next you can prepare the jeets-tracker.


Send Traccar Protobuffer Messages to Traccar GTS
===============


	jeets-tracker-1.2-RC-jar-with-dependencies.jar

	tracker.host=localhost
	tracker.port=5200
	tracker.uniqueId=pb.device






