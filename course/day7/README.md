# Integration lesson

Following guide is intended to help in integrating the SPA application developed during FE course with the application developed during BE course.


##### Steps:
- change your ajax url calls on FE project pointing to the BE exposed REST services
- run your FE application
- run your BE application (if you need to change port, please add `server.port=8081` property to `application.properties`)
- open your browser pointing your FE app
- your articles are not displayed, open inspector and check the error inside console and network



##### Solution:
Use the links provided in the slides to implement a solution on BE sides (in spring project) to enable CORS Requests only for your application.
Be careful: maybe you need also changes on how ajax calls are performed on FE project side.