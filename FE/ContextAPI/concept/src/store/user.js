import React , {createContext } from 'react'

export const UserContext = createContext() // 비어있는 context (창고) 반환 ( "생성" )

const UserStore = (props) => {
    const users = {
        name : "woongjae",
        job : 'developer'
    } // context에 넣고싶은 값(소포)을 만들어줌 
    
    return <UserContext.Provider value ={users}>{props.children}</UserContext.Provider>;
    //Context.Provider : context 변경 사항을 자손들에게 제공할 수 있도록 함. 
    //                   Provider의 value는 하위의 모든 consumer에서 사용가능하며, value가 변경 될 때마다 재 렌더링됨.
    
    //Context.Consumer : context provider value의 변경 사항을 구독하며, 가장 가까운 provider의 value를 참조한다.
    
};

export default UserStore;