import React from "react"
import ReactDOM from "react-dom"
import "./registerstyle.css"
export default function Register(){

    return(

        <div className="login"> 
        <i><h2>- / / - register - \ \ -</h2></i>
        <hr/> 
        <div className="flexcont">
            <div>
                <p>--first name-</p>
                <input type="text"/>
            </div>
            <div>
                <p>-last name--</p>
                <input type="text"/>
            </div>
        </div>

        <p>--birth date--</p>
        <input type="date" max="2022-02-02"/>

        <p>--gender--</p>
        <select name="gender">
            <option value="male">
                Male
            </option>
            <option value="female">
                Female
            </option>
            <option value="diverse">
                Other
            </option>
        </select>
        <hr/>
        <div className="flexcont">
            <div>
                <p>--username-</p>
                <input type="text"/>
            </div>
            <div>
                <p>-email--</p>
                <input type="text"/>
            </div>
        </div>
        <hr/>
        <div className="flexcont">
            <div>
                <p>-street-</p>
                <input type="text"/>
            </div>
            <div>
                <p>-house nr.-</p>
                <input type="text"/>
            </div>
        </div>
        <div className="flexcont">
            <div>
                <p>-block nr.-</p>
                <input type="text"/>
            </div>
            <div>
                <p>-door nr.-</p>
                <input type="text"/>
            </div>
        </div>
        <div className="flexcont">
            <div>
                <p>-zipcode-</p>
                <input type="text"/>
            </div>
            <div>
                <p>-city-</p>
                <select>
                    <option>
                        test
                    </option>
                </select>
            </div>
        </div>
        <hr/>
        <p>--phone number--</p>
        <div className="flexcont">
            <div>
                <select>
                    <option>
                        +43
                    </option>
                </select>
            </div>
            <div>
                <input/>
            </div>
        </div>
        <hr/>
        <p>--password--</p>
        <input type="password" />
        <br/>
        <br/>
        <button type="submit">
            register
        </button>
    </div>


    )


}