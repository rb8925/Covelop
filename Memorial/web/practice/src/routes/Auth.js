import { authService, firebaseInstance } from 'fbase';
import React, { useState } from 'react';

const Auth= () => {
    const [email, setEmail]=useState("");
    const [password, setPassWord]=useState("");
    const [newAccount, setNewAccount]=useState(true);
    const [error, setError] = useState("");
    const onChange = (event) =>{
        const {target: {name, value}} = event;
        if(name === "email"){
            setEmail(value);
        }
        else if(name === setPassWord(value)){
            setPassWord(value);
        }
    };
    const onSubmit = async (event) =>{
        event.preventDefault();
       try{
           let data; 
           if(newAccount){
            data= await authService.createUserWithEmailAndPassword(email,password);
        }else {
           data=  await authService.signInWithEmailAndPassword(email, password);
        }console.log(data);
    } catch(error){
            setError(error.message);
        }
    };
    const toggleAccount = () => setNewAccount((prev)=> !prev);
    const onSocialClick = async(event)=>{
        const {target:{name},
    }= event;
    let provider;
    if(name==="google"){
        provider = new firebaseInstance.auth.GoogleAuthProvider();
    }
    await authService.signInWithPopup(provider);
    };
return(
<div>
    <form onSubmit={onSubmit}>
        <input name = "email" type = "email" placeholder="Email" required value={email}  onChange = {onChange}/>
        <input name = "password" type = "password" placeholder ="Password" required value={password} onChange = {onChange}/>
        <input type = "submit" value={newAccount ? "Create Account" : "Log In"}/>
        {error}
    </form>
    <span onClick={toggleAccount}>{newAccount ? "Log in" : "Create Account"}

    </span>
    <div>
        <button onClick={onSocialClick} name="google">Continue with Google</button>
    </div>
</div>
);
};
export default Auth;