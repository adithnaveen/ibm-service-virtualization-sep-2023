# Service Virtualization Training Sep 2023 


## Instructions 

- excel sheet containing Vm details for Participants.
- https://thinkwrightin-my.sharepoint.com/:x:/g/personal/niyaz_k_thinkwright_in/EUcxa7fnlsdPhCbusYoaf2sBO6q3vDLmSRnCYHWf-wWUUA?e=Y4Ppd2



# Introduction 

- Amita - 14 years exp, in test 7-8 years, banking and financial service, to explore more on testing on API and how it works 

- Asha - 20 Years exp, was working as BA & Testing, manual testing recently is automation testing.  To create a framework in API Testing.  To know how testing to technology agnostic + in microservice testing mostly with python + implement i current project 

- Bala Koteshwar Rao - 

- Kasaiah (Kasi)-  18 years in software industyr, with IBM 14 Years, in manual and automation testing working as arch as of now working with java & python,  have started API Testing.  exploring on auth etc, when api is not ready still how it works 

- Mudita - working with testing 17 years, working as Test Arch, exp with manual, automation + API, service vitualization keen to explore 

- Pranathi - 17 Years exp, 12 year in application tester, worked with mobile testing, have worked with API testing + to implement 

- sairam - 

- Shaik Maqbool - working as fullstack tester, doing mainframe testing using MS SQL Server, have worked with performance, trying to understand API, web server architecture  to know what is mockito + serive virtualization testing 

- Shaik Tajuddin - 

- Souvik Ghosh - working in automation with UI, have dont manual testing too, how to automate test with Mockito 

- Vani Pratyusha - working as project delivery manager , with 16 years exp.  worked with manual and automation + selenium testing + api working with telecom project 





## List Of Softwares

- Windows/Linux/MAC OS - with 12 GB Ram 
- Open Internet connection for getting dependencies 
- Java 11 to be installed - https://www.oracle.com/in/java/technologies/javase/jdk11-archive-downloads.html
- Eclipse JEE to be installed -  https://www.eclipse.org/downloads/download.php?file=/technology/epp/downloads/release/2023-06/R/eclipse-java-2023-06-R-win32-x86_64.zip
- Postman - https://www.postman.com/downloads/



## Notes 

- Rest Templage 

```

      return restTemplate.exchange("
         http://yoursite.com/products/123", HttpMethod.GET, entity, String.class).getBody();
   
```

- Java Programming Language 
- functional programming 
    - Ruby 
    - R 
    - Groovy 
    - Kotlin 
    - java 1.8 


- functional interfaces - are those interfaces which shall have single function / method 

```
    interface Hello {
        one();
    }


    interface Consumer {
        void accept();
    }
```

- sorting  
    1. comparable 
    2. comparator 

### ways to testing 
    - write in the main method 
    - look for some test framework 
        - junit 
            - 4 
            - 5 
        - testng 


# Day2 


## working with contracts 

```
    interface IGetConnection {
        public Connection getConnection(...); 
    }

    // delhi 
    class MysqlConnection implements IGetConnection {
        public Connection getConnection(...) {
            // BL 
        }
    }

    // blr 
    class PostGressConnection implements IGetConnection  {
        public Connection getConnection(...){
            // BL 
        }
    }

       // hyd 
        class MongoDbConnection implements IGetConnection{
        public Connection getConnection(...){
            // BL 
        }
    }

    IGetConnection connection = new MysqlConnection(); 
    myc.connection(); 

   connection = new PostGressConnection(); 
    psc.getMyConnection(); 

   connection= new MongoDbConnection(); 
    mdc.getConnection(); 



    List<String> list = new ArrayList();
    ... 
    list = new Vector();
```


-- working with polymorphism 


```
------------ contract -----------
    interface Shape {
        public void area(); 
    }

    ------------- concrete class --------------
    class Circle implements Shape{
        public void area() {
            ...
        }

    }
    class Square implements Shape{
        public void area() {

        }
    }
    class Rectangle implements Shape {
        public void area() {
                .....
        }
    }

    class Trapesiam implents Shape {
        public void area() {
                .....
        }
    }

--------------- BL -------------- 
    class CalculateArea() {
        public void calculateAreaOfShape(Shape s) {
            s.area()
        }
    }
--------client / impl / app --------

    CalculateArea ca = new CalculateArea(); 

    Shape c = new Circle(); 
    ca.calcuateAreaOfShape(c); 

    c = new Square(); 
    ca.calcuateAreaOfShape(c); 

    c = new rectangle(); 
    ca.calcuateAreaOfShape(c); 
```

- asserting throws (excpetion)

```
  @Test
    void exceptionTesting() {
        Exception exception = assertThrows(ArithmeticException.class, () ->
            calculator.divide(1, 0));
        assertEquals("/ by zero", exception.getMessage());
    }

```


- case for group testing 
    - insert record 
    - get the record pass 
    - delete the record 
    - get the record failed case


- internaces are abstract 
- the classes are concrete 

### mockito 

```

    Stock stock = of infosys -> to external API (putting effort to get the data is not a good idea )
        - input -> infosys -> some body to to get me the data (mocking framework 1234)
        - output -> 1234 

        - assertEquals(expected, actual)
        - assertEquals(1234, given by mockito) - mockito will give yout what you give it to it 

```
    List mockedList = mock(List.class);

    mockedList.add("one");

    assertEquals(1, mockedList.size());
```


- need of hamcrest 
```
    assertEquals("hi", "hi"); 

    assertThat(list, actualList); 


- BDD 
    - Given 
    - When 
    - Then 

<br>
 


# Day3 



### Mock and use it 
### BDD 
    - Given - Pre condition 
    - When - actual 
    - Then - post condition 

### tools who use BDD 
    - Mockito 
    - Rest Assured 
    - Cucumber 
    - Tosca 
    - SpringBoot - Test 

### mockito spy
    - spy will work on real objects than contracts(Imaginary objects)
    - spy will not work on List rather works on Vector/ arraylist
    - spy will work for real implementataion /concreted classes 
    - spy with list / set + messageService 
    - mock will hold the reference v/s spy will hold the instance of the class 

```
    AnyClass cls = new AnyClass(); -> spy works here
```
##  methods which are tested 
    - Employee insertEmployee(Employee employee) {...}
    - boolean insertEmployee(Employee employee) {...}
    - Employee getEmployee(int empId) {...}
    - Employee UpdateEmployee(int empId, Employee employee) {...}
    - void deleteEmployee(int empId); (they can only be verified)
        - for delete + get 
## capturing values of complex object - Captor (some live case)
    ```
        class Employee {
            private int empId; 
            private Name name; 
            private double income 
            private Address address; 
        }

        class Name {
            private String firstName; 
            private String lastName; 
        }
        class Address {
            private String street; 
            private String city; 
            private int pin;     
        }

        ---- 

        class Email {
            private String to; 
            private String body; 
            ... 
        }

        assertEquals("vani@gmail.com", actualObject.getTo()); 
        assertEquals("some body ", actualObject.getBody()); 

        ArgumentCaptor <Email> emailCaptor ; 

        .....

        mocking journey goes here 
        verify(platform).deliver(emailCaptor); 

        Email validateEmail = emailCaptor.getValue();
        assertEquals(validateEmail.getTo(), "vani@gmail.com"); 

    ```

-- working with java beans 
    ```
    // make this class a bean class 
    // make variables private 
    // create constructor/s
    // to access create getters and setters 
        class Email {
            private String to; 
            private String subject; 
            private String content; 

            public Email() {} - default constructor 
            public Email(String myto, String subject, String content ) {
                // parametric construction 
                to = myto; 
            }

            public String getTo() {
                return this.to;
            }

            public String getSubject() {
                return this.subject; 
            }

            public void setTo(String to )  {
                this.to = to; 
            }
        }


        class ImplEmail1 {
            public static void main(String args[]) {
                Email email = new Email(); 
                email.to = "d" ; 
                email.subject = "testing"; 
                email.content = "Some content"; 

            }
        }

        class ImplEmail2 {
            public static void main(String args[]) {
                 Email email = new Email(); 
                email.to = "c" ; 
                email.subject = "testing1"; 
                email.content = "Some content1"; 
            }
        }

    ```
## working on restful application + mockito 
    - setup springboot application 
    - perform CRUD operation 
    - test the code with spring context 
    - test the code with spring context  + mockito 
    - test the code with mockito 



# day4 


```

- json 
    {
        "empId":101, 
        "empName":"Naveen"
    }
    -- jackson (springboot which is default) / gson 
- class 
    class Employee {
        int empId; 
        String empName; 
    }

```

- service virtualization 
    - wiremock 
    - tosca 
    - mulesoft 
    ... 

```
    hey wireMock i'll give you 101 give me  
    {
        "empId":101, 
        "empName":"Naveen", 
        "leaves" :{
            available: 12, 
            applied:2
            remainding:10
        }
    }
```


- working with wire mock 
```
    -- to start wire mock server 
    $ java -jar wiremock-jre8-standalone-2.35.0.jar --port 8081 
```

- you can access server 
    - .http 
    - postman 
    - java program 
    - or any programming languages 
- wire mock will take json and give you json / text / xml 


- simple request 
- http://localhost:8081/some/thing when i make GET - testing 

- http://localhost:8081/__admin/mappings - POST 


```
{
  "request": {
    "method": "GET",   
    "url": "/ibm/hello-world-text"
  },

  "response": {
    "status": 200,
    "body": "Hello, world!",
    "headers": {
        "Content-Type": "text/plain"
    }
  }
}

-- 


{
    "id": "380ff988-bff7-4187-bd0d-8a618bfbd0cd",
    "request": {
        "url": "/ibm/hello-world-text",
        "method": "GET"
    },
    "response": {
        "status": 200,
        "body": "Hello, world!",
        "headers": {
            "Content-Type": "text/plain"
        }
    },
    "uuid": "380ff988-bff7-4187-bd0d-8a618bfbd0cd"
}
```


- making request for json object 
```
{
  "request": {
    "method": "GET",   
    "url": "/ibm/hello-world-json"
  },

  "response": {
    "status": 200,
    "body": "{"empId" : 101, "empName":"Harry", }",
    "headers": {
        "Content-Type": "application/json"
    }
  }
}
```
- verify link - http://localhost:8081/ibm/hello-world-json


```
    - query parameter 
        http://localhost:8081/__admin/mappings/myuri?uuid=<uuid>&_page=2&order=asc

        GET /posts/1/comments/_start/20/_limit/10
        https://github.com/adithnaveen/ibm-service-virtualization-sep-2023
        https://github.com/adithnaveen/ibm-service-virtualization-sep-2023/tree/main/workspace/java8-testing-works/mockito-src/com/ibm/data
```



- GET - Get All  - http://localhost:8081/__admin/mappings
- GET {ID} - Get By Id  - http://localhost:8081/__admin/mappings/<UUID>
- POST - Create - http://localhost:8081/__admin/mappings
- PUT - Update  http://localhost:8081/__admin/mappings/<UUID> - body with updated value 
- DELETE - Delete - http://localhost:8081/__admin/mappings/<UUID>


- pattern matching 
```
{
    "request": {
        "method": "ANY",
        "urlPattern": ".*"
    },
    "response": {
        "status": 404,
        "jsonBody": { "status": "Error", "message": "Endpoint not found" },
        "headers": {
            "Content-Type": "application/json"
        }
    }
}
```


// http://localhost:8081/emp/<anyvalue>
``` 
{
    "request": {
        "priority":10, 
        "method": "GET",
        "urlPattern": "/emp/.*"
    },
    "response": {
        "status": 200,
        "jsonBody": "{'empId' : 101, 'empName':'Harry', 'city':'bengaluru'}",
        "headers": {
            "Content-Type": "application/json"
        }
    }
}
 
```


- get employee 
```
{
    "request": {
        "method": "GET",
        "urlPattern": "/emp/1"
    },
    "response": {
        "status": 200,
        "jsonBody": {'empId' : 1, 'empName':'Harry', 'city':'bengaluru'},
        "headers": {
            "Content-Type": "application/json"
        }
    }
}

```

```
    - variable arguments in java 
    class Delete {
        public void doSomeWork(String arg1, String arg2, String ... args) { // correct 

        }

        doSomeWork("hi", "bye"); // still work 
        doSomeWork("hi", "bye", "cya", "bye bye"); // still work 
    }


     class Delete {
        public void doSomeWork( String ... args, String arg1, String arg2,) { // not correct 

        }

        doSomeWork("hi", "bye"); // still work 
        doSomeWork("hi", "bye", "cya", "bye bye"); // still work 
    }
```



- for 404 least priority 

```
{
    "priority": 50,
    "request": {
        "method": "ANY",
        "urlPattern": ".*"
    },
    "response": {
        "status": 404,
        "jsonBody": { "status": "Error", "message": "Endpoint not found" },
        "headers": {
            "Content-Type": "application/json"
        }
    }
}
```


1. creating simple request - text 
2. creating simple request - json 
3. Pattern matching 
4. prioirity 
5. CRUD with Mapping 
6. Save 
7. proxyBaseUrl
```
{
    "request": {
        "method": "GET",
        "urlPattern": "/courses/.*"
    },
    "response": {
        "proxyBaseUrl": "https://probits.in"
    }
}
```
8. working with bodyFileName

    ```
    {
    "request": {
        "method": "GET",
        "url": "/employee/1234"
    },
    "response": {
        "status": 200,
        "bodyFileName": "../__files/employee.json"
    }
}

--



 {
    "request": {
        "method": "GET",
        "url": "/employees"
    },
    "response": {
        "status": 200,
        "bodyFileName": "../__files/employees.json"
    }
}
    ```

pratyu.176@gmail.com

