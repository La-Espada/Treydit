import react from "react"
import reactDOM from "react-dom"
import styles from "./landing.module.css"
import { BrowserRouter, Route, Switch, useNavigate } from "react-router-dom";
import {NavLink} from "react-router-dom";





export default function Landing(){
let navigate = useNavigate();

    return(

            <div className={styles.container}>

             <section className={styles.cover} style={{backgroundImage: 'url(' + require('./test1.gif') + ')'}} >

                <div className={styles.title}>

                 <pre className={styles.treydit}>treydit</pre>
                 <pre className={styles.last}>your last exchange platform</pre>
                 <div className={styles.button}>

                    <button onClick={()=> navigate('/register')}>get started now</button>
                    <button>about us</button>


                </div>
                <button onClick={()=> navigate('/login')}>Already treyder?</button>
                </div>
            </section>
    </div>

    )
}