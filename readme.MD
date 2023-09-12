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
```

- BDD 
    - Given 
    - When 
    - Then 