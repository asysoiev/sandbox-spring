class Contact {

    def firstName
    def lastName
    def birthDate

    String toString() {
        "($firstName,$lastName,$birthDate)"
    }
}

Contact contact = new Contact(firstName: 'Chris', lastName: 'Schaefer', birthDate: new Date())
Contact anotherContact =
        new Contact(firstName: 42, lastName: 'Schaefer', birthDate: new Date())
println contact
println anotherContact
println contact.firstName + 42
println anotherContact.firstName + 42