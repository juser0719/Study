## 📚 Context 어떻게 쓸까? 🤔

context api는 기존의 상태 관리 라이브러리와 작동 원리는 일맥상 비슷~ 합니다.

👇 대충 이런 느낌으로 Context store ( 통칭 창고 ) 에서 부모로 부터 전해받는 계승? 같은 느낌이라기 보단 공공 창고에서 허가받은 사람은 들어가서 필요한 것을 가져오는 느낌으로 바뀐거죠!

![](https://images.velog.io/images/j_user0719/post/c8e27a64-0cd5-4a4b-a97d-f3ccb99a547b/image.png)

그렇다면 직접 간단한 예제를 기반으로 예시를 들도록 하겠습니다.

## 🔨 준비물 

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

export default function 이름 () {
    return (
        <div>
            <h3>이름 page!!!</h3>
        </div>
    )
}
```

위와 같이 라우팅이 처리된 app.js 파일과 라우팅이 처리된 각각의 컴포넌트를 만들어 줍니다!


## 1️⃣ 창고 만들기

자 이제 준비물이 만들어졌습니다. 이제 모두가 사용할 수 있는 창고를 만들어야 합니다! 

### Store.js

```
import React , { createContext } from 'react'

export const UserContext = createContext() 
// createContext : 비어있는 창고 생성!

const UserStore = (props) => {
    const users = {
        name : 'j-user',
        job : 'developer'
    } 
    // 창고에 넣고싶은 값을 만들어줌 
    
    return <UserContext.Provider value ={users}>{props.children}</UserContext.Provider>;
};

export default UserStore;
```

마지막 ```UserContext.Provider ```를 제외하고는 주석에 설명을 참고하시고, Context를 사용할때 사용할 여러가지 함수가 있기에 잠시 정리하고 가도록 하겠습니다. ( [참고](https://ko.reactjs.org/docs/context.html#classcontexttype) ) 

- React.createContext : Context 를 만들때 씀.

>```const Store = React.createContext(defaultValue)```
  
- Context.Provider : Context 변경 사항을 자손들에게 제공 할 수 있고, Value는 하위의 모든 Consumer 에서 사용할 수 있으며, Provider 하위의 모든 Consumer 는 Provider 의 value가 변경 될 때마다 재 렌더링 된다.

```<MyContext.Provider value={/* some value */}></MyContext.Provider>```

- Context.Consumer :  Provide의 Value의 변경 사항을 구독하며, Context 에서 가장 가까운 Provider 의 Value 를 참조한다.

>```<MyContext.Consumer>{(value) => (/* render something based on the context value */)}</MyContext.Consumer>```

- Class.contextType : Class 의 contextType 에 Context 객체를 할당 할 수 있다.

- React.useContext : useContext로 Context 객체의 value를 가져올 수 있다.

>```const value = useContext(MyContext);```


## 2️⃣ 창고 출입증 발부

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
```

## 3️⃣ 필요한 데이터 가져가기

### About.js / Profile.js

```
import React , { useContext }from 'react';
import {UserContext} from '../store/user';

export default function About () {
    const context = useContext(UserContext) // cotext를 사용할땐 useContext
    return (
        <div>
            <h3>{context.name}</h3>
        </div>
    )
}

```
