# address-book-state-machine

I've build this project as a maven project.<br>
I've used the state pattern for implementation.<br>
<br>

### Project structure:

#### model - this is the context. 

	AddressBook - holds a list of business cards and expose 2 methods - 1 to add trusted business cards and the second for adding untrusted business cards.
                  I've created it as a Singleton because I want only one instance of the address book.
    BusinessCard - an abstract class that holds the state interface, attributes and 2 abstract methods that will be implemented by the 2 business card types.
    TrustedBusinessCard - extends the BusinessCard. represents the trusted business card. will call the state doAction method and will transition to the given state.
    UnTrustedBusinessCard  - extends the BusinessCard. represents the untrusted business card. will call the state doAction method and will transition to the given state.

#### states - holds all the states in the system and their logic

    BusinessCardState - the state interface that holds the methods to be implemented by the concrete states. 
    5 states that implemets the state interface with their logic.

#### Client - main method that adds the business cards and move their states.

#### tests - 

    AddressBookStateTests - holds Junit tests that verify the state machine works as expected. (currently holds onlly happy cases)
