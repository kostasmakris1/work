incentive-coding-test
=====================

This is a toy webapp to test the new candidate skills.

To run app type:
mvm clean install jetty:run

It will spin jetty container on local port 8080

To execute the tests run the test class
Under resources, I have added json templates for the different requests/responses. I use pojos and convert them to java objects.
The Request builder is used to build the several requests using http client. This is done in the ApiUtils. The data is stored into messageContext object
and is retrieved in step definitions for the assertions.
