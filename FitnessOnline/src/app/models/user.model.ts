export class User{
    id:       number;
    fname:    string;
    lname:    string;
    uname:    string;
    email:    string; 
    password: string; 
    trainer:  boolean; 
    contact:  string; 
    city:     string;
    avatar:   string;


    
    constructor(
        fname:    string, 
        lname:    string, 
        uname:    string, 
        email:    string, 
        password: string, 
        trainer:  boolean, 
        contact:  string, 
        city:     string, 
        avatar:   string
    ){
        this.fname = fname;
        this.lname = lname;
        this.uname = uname;
        this.email = email;
        this.password = password;
        this.trainer = trainer;
        this.contact = contact;
        this.city = city;
        this.avatar = avatar;
    }
}