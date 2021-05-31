import React, {creacteContext, useState} from 'react'

export const ThemeContext = creacteContext();

function ThemeContextProvider(){
    const [isLightTheme,setIsLightTheme] = useState(true)
    const [light,setLight] = useState({syntax : '#555', ui : '#ddd', bg: '#eee'})
    const [dark, setDark] = useState({syntax:'#ddd',ui: '#333', bg: '#555'})
    
    return(
        <ThemeContext.Provider value={}>

        </ThemeContext.Provider>
    )
}

export default ThemeContextProvider;