# xss-demo

The `xss-demo` project is a benchmark project provided for Oxpecker, a vulnerability scanning product developed by Entropool. This project offers benchmarks and test cases to facilitate product development, debugging, and functional testing.

## Purpose

The purpose of the `xss-demo` project is to provide a set of benchmarks and test cases for testing Cross-Site Scripting (XSS) vulnerabilities. It includes various servlets designed to handle requests and demonstrate XSS vulnerabilities by reflecting user-supplied input in the response.

## Setup Instructions

### Prerequisites

- Java Development Kit (JDK) 8 or higher
- Apache Maven

### Build and Package

To build and package the `xss-demo` project, follow these steps:

1. Clone the repository:
   ```bash
   git clone https://github.com/entropool/xss-demo.git
   cd xss-demo
   ```

2. Set the `JAVA_HOME` environment variable to point to your JDK installation.

3. Install Maven if it is not already installed.

4. Run the following Maven command to clean and package the project:
   ```bash
   mvn clean package -DskipTests
   ```

### Run the Service

To run the `xss-demo` service, use the following command:
```bash
java -jar target/demo-0.0.1-SNAPSHOT.war
```

The service will start and listen on a port (e.g., 8091). You can access the service at the following URL:
```
http://localhost:8091
```

## API Endpoints

The `xss-demo` project includes several servlets mapped to URL patterns under `/xss-00/*`, `/zptest/*`, and `/jetest/*`. These servlets are designed to handle both GET and POST requests and demonstrate XSS vulnerabilities by reflecting user-supplied input in the response with the `X-XSS-Protection` header set to "0".

### List of API Endpoints

#### `/xss-00/*` Endpoints
1. `/xss-00/BenchmarkTest00036` - Defined in `BenchmarkTest00036.java`
2. `/xss-00/BenchmarkTest00150` - Defined in `BenchmarkTest00150.java`
3. `/xss-00/BenchmarkTest00047` - Defined in `BenchmarkTest00047.java`
4. `/xss-00/BenchmarkTest00144` - Defined in `BenchmarkTest00144.java`
5. `/xss-00/BenchmarkTest00049` - Defined in `BenchmarkTest00049.java`
6. `/xss-00/BenchmarkTest00030` - Defined in `BenchmarkTest00030.java`
7. `/xss-00/BenchmarkTest00041` - Defined in `BenchmarkTest00041.java`
8. `/xss-00/BenchmarkTest00014` - Defined in `BenchmarkTest00014.java`
9. `/xss-00/BenchmarkTest00148` - Defined in `BenchmarkTest00148.java`
10. `/xss-00/BenchmarkTest00149` - Defined in `BenchmarkTest00149.java`
11. `/xss-00/BenchmarkTest00048` - Defined in `BenchmarkTest00048.java`
12. `/xss-00/BenchmarkTest00146` - Defined in `BenchmarkTest00146.java`
13. `/xss-00/BenchmarkTest00145` - Defined in `BenchmarkTest00145.java`
14. `/xss-00/BenchmarkTest00013` - Defined in `BenchmarkTest00013.java`

Each servlet processes parameters from the request, specifically looking for parameters named after their respective `BenchmarkTest00xxx` and outputs their values in the response. Some servlets use additional strings or perform conditional logic before reflecting the data back in the response.

#### `/zptest/*` Endpoints
1. `/zptest/msg/get` - Defined in `MsgController.java`
2. `/zptest/msg/save` - Defined in `MsgController.java`

The `/zptest/msg` endpoints handle GET and POST requests to retrieve and save messages, respectively. The `get` endpoint returns a view named `getmsg`, while the `save` endpoint saves a message without returning a view.

#### `/jetest/*` Endpoints
1. `/jetest/getMessage` - Defined in `JCloudProviderController.java`

The `/jetest/getMessage` endpoint handles GET requests and returns a message based on the provided `name` parameter.

#### Other Endpoints
1. `/live_verify_{code}.txt` - Defined in `LiveVerifyController.java`

The `/live_verify_{code}.txt` endpoint handles requests and responds with the `code` path variable as the body of the response.

## Contributing

Contributions to the `xss-demo` project are welcome. Please follow the standard GitHub workflow for contributing:

1. Fork the repository.
2. Create a new branch for your feature or bug fix.
3. Make your changes and commit them with descriptive commit messages.
4. Push your changes to your forked repository.
5. Create a pull request to the main repository.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

## Contact

For any questions or inquiries, please contact the project maintainers at [support@entropool.com](mailto:support@entropool.com).
