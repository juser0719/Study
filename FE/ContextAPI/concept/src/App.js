import React from "react";
import { BrowserRouter as Router, Route, Switch } from "react-router-dom";
import About from "./pages/About";
import Profile from "./pages/Profile";
import UserStore from './store/user' 
export default function App() {
  return (
    <UserStore>
      {/* 하위에 있는 모든 컴포넌트들이 context 접근이 가능하도록 하기 위함. */}
    <Router>
      <Switch>
        {/* <UserStore> */}
        <Route path="/title" component={About} /> 
        {/* </UserStore>  만약 이렇게 된다면 context에 About만 접근 가능. */}
        <Route path="/user" component={Profile} />
      </Switch>
    </Router>
    </UserStore>
  );
}