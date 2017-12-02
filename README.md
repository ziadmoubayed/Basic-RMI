# Basic RMI Test

----
Simple Java Application to debug basic RMI issues.
First Run the adaptor on a remote machine and then start the manager.
You need to pass two arguments adaptor host and port to both manager and adpator so they can connect.
----
## usage
1. Clone the project
2. Build it and cd target
3. Run Adapter
java -cp TestRmi-0.0.1-SNAPSHOT.jar standalone.StartAdaptor <adaptorHost> <adaptorPort>
4. Run Manager
java -cp TestRmi-0.0.1-SNAPSHOT.jar standalone.StartManager <adaptorHost> <adaptorPort>

