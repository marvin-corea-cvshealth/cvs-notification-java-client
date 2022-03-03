# cvs-notification-client 
The notification health client is a java based service api to send prescription notification emails at CVS.

This is a reminder from CVS Mart at Blue Ave. You have prescriptions ready for pickup. Questions? Please call us at (999) 999-9999.

## Adding cvs-notification-client to your project
### POM
    <dependency>
			<groupId>com.cvs.notification</groupId>
			<artifactId>cvs-notification-client</artifactId>
			<version>0.0.1-SNAPSHOT</version>
			<systemPath>${pom.basedir}/src/main/resources/cvs-notification-client-0.0.1-SNAPSHOT.jar</systemPath>
			<scope>system</scope>
		</dependency>
 ### Sample code
    import com.cvs.notification.NotificationClient;
    NotificationClient client = new NotificationClient();
    client.callNotification(userEmail, "Refill");
 ### Output
![image](https://user-images.githubusercontent.com/98829230/156649535-1fd2582c-146c-46a6-9d6d-838c9ee21b9e.png)
