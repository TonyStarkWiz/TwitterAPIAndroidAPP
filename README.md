# TwitterAPIAndroidAPP

TransformFragment: Home "Launch Scalper Bot" (User interaction on UI by inputting your text word tweet or hashtag to scape twitter for)
ReflowFragment: Tweets (populates the targeted tweets by text word tweet or hashtag and if click on it directs you to the tweet in the the Twitter Application)
SettingsFragment: Settings (extra feature not fully implemented yet) 
SideshowFragement: Sideshow (extra feature not fully implemented yet) 

Development Steps

- [x] Step 1: Data Classes “Our Model” The Polio Object from JSON
	“All data classes are public by default”

- [x] Step 2: Retrofit Interface “The REST folder”
    - [x] @GET() method “for the path for out URL”
    - [x] Network call: Then we need to define our function to get the data “using coroutines” 
    - [x] Wrap Response with object coming from Retrofit
    - [x] Companion object{
        - [x] Base URL “ends with /“ & PATH “between / and ?” & Queries “after ?”}
- [x] Step 3: Repository layer “The actual interactor with the ViewModel “The REST folder”
    - [x] Interface: Implementation Class “In the same file you can create the Interface & Class”: that implements the interface repository: create the methods inside
        - [x] In the methods what we need is the (name  & return type from the Interface Services): same # of suspend functions room Interface Services   
        - [x] 	mandatory parameters from Interface Service goes inside the methods
    - [x] Class: Implement its members “the methods created in the Interface you have to implement some functionality” (inside these functions is the actually place to do the network call/service API) 
        - [x] In the Constructor of that Implementation I’m going to be passing the Service Interface
            - [x] Define a variable for are Service Interface 
                - [x] Return the correct method
                - [x] *Remember: every time you need a new parameter you don’t need to create a new function, you can add a new parameter in the variable Interface *
- [x] Step 4: Dependency Injection & Dagger
    - [x] Create: Component & Module 
        - [x] Application Module Class: add @Module if its Dagger
            - [x] pass Context in the constructor “private var applicationContext”  
            - [x] provide the Context with functions that will provide our Context:
                - [x] annotate the function with @Provides on top & fun providesContext(): Context  
                - [x] return the applicationContext
    - [x] NetworkModule: Class, @Module on top
            - [x] provide the Retrofit Interface with functions that will provide our Retrofit Interface: fun providesNetworkService(okHttpClient: OKHttpClient) = 
            - [x] ConverterAdapter: To covert JSON to The Polio Class using:“.addConverterFactory(Factory(GSONConverterFactory.create())”
            - [x] Inceptor: .client(okHttpClient)
            - [x] .build()
            - [x] Retrofit will allow us to create our Interface “.create(Services)”: we pass the Class name of our service “Services”
            - [x] Create another function to provide the OKHttpClient
            - [x] connectionTimeout & readTimeout & writeTimeout
            - [x] .build() the object 
            - [x] provide the repository by another function with the Interface “movieService”: @Provides 
  		fun providesMovieRepository(movieService : Service): MovieRepository = 
            - [x] Then the implementation after the equals: we need the instance of it & pass the movieServices: MovieRepositoryImpl(movieServices) 
    - [ ] Component: create a new Interface for our Component
        - [ ] Component annotation on top of Interface: @Component 
        - [ ] It needs modules inside the @Component(modules = [ApplicationModule::class, NetworkModule::class])
            - [ ] We need the Inject modules inside the method
                - [ ] Inside that Inject we will be passing the MainActivity *Remember we don’t implement default functions in Interfaces 
	If we have fragments we need to add also with MainActivity
    - [ ] create an Application Class, add this Class to the manifest 
    - [ ]  actually build Dagger: override the onCreate method in the MovieApp Class 
        - [ ] create companion object to hold my component with a lateinit var: assign that variable inside the onCreate method:
moviesComponent = DaggerMoviesComponent.builder().applicationModule(ApplicationModule(this)).build()
“we instantiate a new application module inside” 
