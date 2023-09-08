# Java-Spring-Boot-Endpoint
A Java Spring Boot Endpoint
This Java project provides a simple RESTful endpoint that takes two GET request query parameters and returns specific information in JSON format. The information includes:

- Slack name
- Current day of the week
- Current UTC time (with validation of +/-2)
- Track
- The GitHub URL of the file being run
- The GitHub URL of the full source code
- A Status Code of Success


## Getting Started

### Prerequisites

Before running this project, you'll need to have the following installed:

- [Java](https://www.java.com/)
- [Maven](https://maven.apache.org/)

#### Installation

1. Clone the repository to your local machine:
   
   ```bash
   git clone https://github.com/yourusername/java-restful-endpoint.git

2. Navigate to the project directory:
   
   ```bash
   cd java-restful-endpoint
   //Build the project using Maven:
   mvn clean install
   //Run the application:
   mvn spring-boot:run

The application will start and be accessible at http://localhost:8080

#### Usage

To use this RESTful endpoint, make a GET request to the following URL:

 http://localhost:8080/get-info?slackName=YourName&utcOffset=2

Replace YourName with your Slack name and 2 with your desired UTC offset value (between -2 and 2).

### API Endpoint

Endpoint: /get-info
Method: GET
Query Parameters:
slackName (required): Your Slack name.
utcOffset (required): Your UTC offset value (between -2 and 2).
Example usage:
#### GET http://localhost:8080/get-info?slackName=JohnDoe&utcOffset=0

### Customization
You can customize the following aspects of the response:

track: Edit the track information in the InfoResponse class.

gitHubFileUrl: Replace with the URL to the GitHub file being run.

gitHubSourceUrl: Replace with the URL to the full source code on GitHub.

Error Handling
If you provide an invalid utcOffset value (outside of the +/-2 range), the endpoint will return a custom error response with a 400 Bad Request status code.

### Contributing
Contributions are welcome! If you'd like to contribute to this project, please follow these steps:

Fork the repository.

Create a new branch for your feature or bug fix.

Make your changes and commit them.

Push your changes to your fork.

Submit a pull request to the original repository.
