JeeTS Protocols for Traccar ORM
===============
This project represents the core of GPS Tracking. 
jeets-protocols is a subset of the jeets-pu-traccar ERM and ORM  
which can be converted from Java Entities to binary Protobuffer messages and vice versa.
The Transformer (see TransformerTest) represents sending
and receiving of Traccar messages for the complete Tracking System.

Note that the protocol is *not* designed to transfer every Entity of jeets-pu-traccar with Relations.
It focuses on the clients tracking data defined by Device, Position/s and Event/s.

The protocol can be extended to include GeoFences for example. Some Devices store GeoFences locally,
to be exchanged with the server. The protocol should *not* be extended to Entities
that only matter on server side, i.e. User etc. This could potentially introduce
administrative actions and hard to detect security issues. 

This project provides a jeets-protocols.jar module with Google Protobuffer Java accessors.
The artifact includes the *.proto source files for easier debugging (remove if needed).
The module also contains the Traccar Persistence Unit, which can also be created without
JPA and EntityManager and transformed into binary Protobuffer messages.
The project does *not* include a transmission technology, i.e. Netty for TCP.


Modeling differences
-

The Transformer (currently) is focused on Object Relations between Device, Positions and Events. 
These relations are modeled different in Persistence Unit and Protobuffer. 
Both model many Events for one Position, i.e. n:1 via a unidirectional relation - only from different directions. 
By design decision Events must have a Position to determine where and when the Event took place. 
Therefore Events without Positions should be ignored (shouldn't be created in the first place). 

In the Protobuffer Model a Device can hold many positions and each position can hold many events. 
Each event is accessed via the position parent. 

In the Persistence Unit a Device can hold many positions and many events.
The event.position has to be looked up in the device.positions.



Traccar Proto Decoder
---------------------
The Book Chapter 7.5 is pointing to 

	\jeets-models\jeets-protocols\src\main\resources

for the ProtobufferDeviceDecoder for the Traccar GTS.
The Decoder has been updated to Traccar 4.2 and
the moved up to the project folder 

	\jeets-models\jeets-protocols\traccar-proto-decoder

Please read instructions there to add Protobuffer Messages to Traccar
and send Messages with the jeets-tracker.


How to generate java files
-
Before running maven the java accessors have to be created with an installation of the protobuffer compiler 'protoc'.
	> protoc --version
	> libprotoc 3.1.0

To compile one or more *.proto files 
	> cd to dir with src folder
	> \jeets-protocols>protoc protobuffers/WorldClockProtocol.proto --java_out=src/main/java

	> \jeets-protocols>protoc --proto_path=./protobuffers --java_out=src/main/java 	
		protobuffers/WorldClockProtocol.proto

How to compile with patterns? 
eHor*.proto *.proto etc. ?
protoc --proto_path=/usr/local/include --proto_path=./csgo --ruby_out=./outlib csgo/**/*.proto

As an extra convenience, if the DST_DIR ends in .zip or .jar, the compiler will write the output to a single ZIP-format archive file with the given name. .jar outputs will also be given a manifest file as required by the Java JAR specification. 

Alternatively, if the .proto file contains:
	option optimize_for = LITE_RUNTIME;
then Foo will include fast implementations of all methods, but will implement the MessageLite interface, which only contains a subset of the methods of Message. In particular, it does not support descriptors or reflection. However, in this mode, the generated code only needs to link against libprotobuf-lite.jar instead of libprotobuf.jar. The "lite" library is much smaller than the full library, and is more appropriate for resource-constrained systems such as mobile phones.

TODO: check 'maven protobuf plugin' to create *.java files !!

Add @SuppressWarnings("all") to the generated code not to pollute IDE task list.
