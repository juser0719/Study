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