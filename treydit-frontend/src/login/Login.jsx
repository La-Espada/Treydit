import React from "react"
import ReactDOM from "react-dom"
import "./loginstyle.css"

export default function Login(){

    return (

        <div className="login">
        <i><h2>- / / - log in - \ \ -</h2></i>
        <p>--username--</p>
        <input type="text"/>
        <p>--password--</p>
        <input type="password"/>
        <br/>
        <br/>
        <button>
            login
        </button>
    </div>

    )
}
