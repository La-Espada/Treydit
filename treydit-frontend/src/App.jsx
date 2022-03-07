import React from "react";
import {BrowserRouter,Route,Routes} from "react-router-dom"
import AddTreyder from "./components/AddTreyder";
import NotFound from "./components/NotFound";
import TreydersList from "./components/Treyderslist";


function App(){
  return (
  <BrowserRouter>
  <div>
    <Routes>
        <Route exact path="/" element={<TreydersList/>}/>
        <Route path ="/add" element={<AddTreyder/>}/>
        <Route path="*" element={<NotFound/>}/>
    </Routes>
  </div>
  </BrowserRouter>
  );
}
  
export default App;
