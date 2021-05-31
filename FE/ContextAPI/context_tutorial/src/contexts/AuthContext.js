import React , {createContext, useState }from 'react'

export const AuthContext = createContext();

function AuthContextProvider (props) {
    const [state,setState] = useState({
        isAuthenticated: false 
    })
    const toggleAuth = () =>{
        setState({isAuthenticated : !state.isAuthenticated})
    }

    return(
        <AuthContext.Provider value={{...state,toggleAuth: toggleAuth}}>
            {props.children}
        </AuthContext.Provider>
    )
}

export default AuthContextProvider