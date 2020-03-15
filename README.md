MockitoTests

Spring boot project with Mockito test cases

Normal Junit testing uses stubs

Problem with Stubs is that, they are very hard to maintain
Any change in the interface will require all the stubs to be updated
Don't provide much info directly, unless naming is really good
At some point, there will be 100 of stubs to test an entire business class which is really troublesome


Mockito
When we use InjectMocks, we don't need to use the @Before code to set the mock, that'll be taken care by the Mockito
Add RunWith(MockitoJunitRunner.class) to test class

SpringRunner.class - can be used to JUnit tests

Arguement Matchers (class) - when(mock.get(anyInt())).thenReturn("parm");
For all the indexes, parm will be mocked
anyChar, anyByte, anyString etc...

Verification:
SUT - System Under Test

verify(mock).get(0); - to check whether mock is called with specific index

A mock does not retain the behavior of the original class

Spy - retains the original behavior of class

Mockito cannot mock:
	-Static methods
	-constructors
	-equals(), hashcode()
	-private methods
	
partial json responses can be matched and test will pass


h2 db (jdbc url) - jdbc:h2:mem:testdb


SpringBootTest Annotation - starts looking at all the pkgs for class having SpringBootApplication - main class
	So it launches entire app context, also launches in memory db
	
Random port - picks up any free port so that test does not fail

TestRestTemplate - enables requests, automatically recognizes the port app is running

Functional - 
Whenever you have an array - convert it to stream
Arrays.stream(data)
