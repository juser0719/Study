## ๐ Context ์ด๋ป๊ฒ ์ธ๊น? ๐ค

context api๋ ๊ธฐ์กด์ ์ํ ๊ด๋ฆฌ ๋ผ์ด๋ธ๋ฌ๋ฆฌ์ ์๋ ์๋ฆฌ๋ ์ผ๋งฅ์ ๋น์ท~ ํฉ๋๋ค.

๐ ๋์ถฉ ์ด๋ฐ ๋๋์ผ๋ก Context store ( ํต์นญ ์ฐฝ๊ณ  ) ์์ ๋ถ๋ชจ๋ก ๋ถํฐ ์ ํด๋ฐ๋ ๊ณ์น? ๊ฐ์ ๋๋์ด๋ผ๊ธฐ ๋ณด๋จ ๊ณต๊ณต ์ฐฝ๊ณ ์์ ํ๊ฐ๋ฐ์ ์ฌ๋์ ๋ค์ด๊ฐ์ ํ์ํ ๊ฒ์ ๊ฐ์ ธ์ค๋ ๋๋์ผ๋ก ๋ฐ๋๊ฑฐ์ฃ !

![](https://images.velog.io/images/j_user0719/post/c8e27a64-0cd5-4a4b-a97d-f3ccb99a547b/image.png)

๊ทธ๋ ๋ค๋ฉด ์ง์  ๊ฐ๋จํ ์์ ๋ฅผ ๊ธฐ๋ฐ์ผ๋ก ์์๋ฅผ ๋ค๋๋ก ํ๊ฒ ์ต๋๋ค.

## ๐จ ์ค๋น๋ฌผ 

### App.js
```
import React from "react";
import { BrowserRouter as Router, Route, Switch } from "react-router-dom";
import About from "./pages/About";
import Profile from "./pages/Profile";

export default function App() {
  return (
    <Router>
      <Switch>
        <Route path="/About" component={About} />
        <Route path="/Profile" component={Profile} />
      </Switch>
    </Router>
  );
}
```
### About, Profile
```
import React from 'react';

export default function ์ด๋ฆ () {
    return (
        <div>
            <h3>์ด๋ฆ page!!!</h3>
        </div>
    )
}
```

์์ ๊ฐ์ด ๋ผ์ฐํ์ด ์ฒ๋ฆฌ๋ app.js ํ์ผ๊ณผ ๋ผ์ฐํ์ด ์ฒ๋ฆฌ๋ ๊ฐ๊ฐ์ ์ปดํฌ๋ํธ๋ฅผ ๋ง๋ค์ด ์ค๋๋ค!


## 1๏ธโฃ ์ฐฝ๊ณ  ๋ง๋ค๊ธฐ

์ ์ด์  ์ค๋น๋ฌผ์ด ๋ง๋ค์ด์ก์ต๋๋ค. ์ด์  ๋ชจ๋๊ฐ ์ฌ์ฉํ  ์ ์๋ ์ฐฝ๊ณ ๋ฅผ ๋ง๋ค์ด์ผ ํฉ๋๋ค! 

### Store.js

```
import React , { createContext } from 'react'

export const UserContext = createContext() 
// createContext : ๋น์ด์๋ ์ฐฝ๊ณ  ์์ฑ!

const UserStore = (props) => {
    const users = {
        name : 'j-user',
        job : 'developer'
    } 
    // ์ฐฝ๊ณ ์ ๋ฃ๊ณ ์ถ์ ๊ฐ์ ๋ง๋ค์ด์ค 
    
    return <UserContext.Provider value ={users}>{props.children}</UserContext.Provider>;
};

export default UserStore;
```

๋ง์ง๋ง ```UserContext.Provider ```๋ฅผ ์ ์ธํ๊ณ ๋ ์ฃผ์์ ์ค๋ช์ ์ฐธ๊ณ ํ์๊ณ , Context๋ฅผ ์ฌ์ฉํ ๋ ์ฌ์ฉํ  ์ฌ๋ฌ๊ฐ์ง ํจ์๊ฐ ์๊ธฐ์ ์ ์ ์ ๋ฆฌํ๊ณ  ๊ฐ๋๋ก ํ๊ฒ ์ต๋๋ค. ( [์ฐธ๊ณ ](https://ko.reactjs.org/docs/context.html#classcontexttype) ) 

- React.createContext : Context ๋ฅผ ๋ง๋ค๋ ์.

>```const Store = React.createContext(defaultValue)```
  
- Context.Provider : Context ๋ณ๊ฒฝ ์ฌํญ์ ์์๋ค์๊ฒ ์ ๊ณต ํ  ์ ์๊ณ , Value๋ ํ์์ ๋ชจ๋  Consumer ์์ ์ฌ์ฉํ  ์ ์์ผ๋ฉฐ, Provider ํ์์ ๋ชจ๋  Consumer ๋ Provider ์ value๊ฐ ๋ณ๊ฒฝ ๋  ๋๋ง๋ค ์ฌ ๋ ๋๋ง ๋๋ค.

```<MyContext.Provider value={/* some value */}></MyContext.Provider>```

- Context.Consumer :  Provide์ Value์ ๋ณ๊ฒฝ ์ฌํญ์ ๊ตฌ๋ํ๋ฉฐ, Context ์์ ๊ฐ์ฅ ๊ฐ๊น์ด Provider ์ Value ๋ฅผ ์ฐธ์กฐํ๋ค.

>```<MyContext.Consumer>{(value) => (/* render something based on the context value */)}</MyContext.Consumer>```

- Class.contextType : Class ์ contextType ์ Context ๊ฐ์ฒด๋ฅผ ํ ๋น ํ  ์ ์๋ค.

- React.useContext : useContext๋ก Context ๊ฐ์ฒด์ value๋ฅผ ๊ฐ์ ธ์ฌ ์ ์๋ค.

>```const value = useContext(MyContext);```


## 2๏ธโฃ ์ฐฝ๊ณ  ์ถ์์ฆ ๋ฐ๋ถ

### App.js

```
import React from "react";
import { BrowserRouter as Router, Route, Switch } from "react-router-dom";
import About from "./pages/About";
import Profile from "./pages/Profile";
import UserStore from './store/user' 
export default function App() {
  return (
    <UserStore>
      {/* ํ์์ ์๋ ๋ชจ๋  ์ปดํฌ๋ํธ๋ค์ด context ์ ๊ทผ์ด ๊ฐ๋ฅํ๋๋ก ํ๊ธฐ ์ํจ. */}
    <Router>
      <Switch>
        {/* <UserStore> */}
        <Route path="/title" component={About} /> 
        {/* </UserStore>  ๋ง์ฝ ์ด๋ ๊ฒ ๋๋ค๋ฉด context์ About๋ง ์ ๊ทผ ๊ฐ๋ฅ. */}
        <Route path="/user" component={Profile} />
      </Switch>
    </Router>
    </UserStore>
  );
}
```

## 3๏ธโฃ ํ์ํ ๋ฐ์ดํฐ ๊ฐ์ ธ๊ฐ๊ธฐ

### About.js / Profile.js

```
import React , { useContext }from 'react';
import {UserContext} from '../store/user';

export default function About () {
    const context = useContext(UserContext) // cotext๋ฅผ ์ฌ์ฉํ ๋ useContext
    return (
        <div>
            <h3>{context.name}</h3>
        </div>
    )
}

```
