import React, {useContext} from 'react';
import {UserContext} from '../store/user';

export default function Profile () {
    const context = useContext(UserContext)
    return (
        <div>
            <h3>{context.job}</h3>
        </div>
    )
}