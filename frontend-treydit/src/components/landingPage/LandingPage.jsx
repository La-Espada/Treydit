import react from "react"
import reactDOM from "react-dom"
import styles from "./landing.module.css"
import { BrowserRouter, Route, Switch } from "react-router-dom";
import {NavLink} from "react-router-dom";

export default function Landing(){


    return(

            <div className={styles.container}>

             <section className={styles.cover} style={{backgroundImage: 'url(' + require('./test1.gif') + ')'}} >

                <div className={styles.title}>

                 <pre className={styles.treydit}>treydit</pre>
                 <pre className={styles.last}>your last exchange platform</pre>
                 <div className={styles.button}>

              <button>get started now</button>
                    <button>about us</button>


                </div>
                </div>
            </section>
    </div>

    )
}