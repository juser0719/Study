import React, { useContext } from 'react';
import { ThemeContext } from '../contexts/ThemeContext';

function Navbar () {
    // const context = useContext(ThemeContext)
    return (
      <ThemeContext.Consumer>{(context) =>{
        const { isLightTheme, light, dark } = context;
        const theme = isLightTheme ? light : dark;
        return(
          <nav style={{background: theme.ui, color: theme.syntax }}>
            <h1>Context App</h1>
            <ul>
              <li>Home</li>
              <li>About</li>
              <li>Contact</li>
            </ul>
          </nav>
        )
      }}

      
      
      </ThemeContext.Consumer>
    );

}

 
export default Navbar;