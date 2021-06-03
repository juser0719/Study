import React, {createContext, useEffect , useReducer} from 'react'
import { bookReducer } from '../reducers/bookReducer';

export const BookContext = createContext();

function BookContextProvider(props) {
    const [books, dispatch] = useReducer(bookReducer,[], ()=>{
        const localData = localStorage.getItem('books'); 
        return localData ? JSON.parse(localData) : [] // 있으면 가져옴
    });

    useEffect(()=>{
        localStorage.setItem('books',JSON.stringify(books))
    },[books])
    //추가하거나 삭제하면 작동

    return(
        <BookContext.Provider value ={{books, dispatch}}>
            {props.children}
        </BookContext.Provider>
    )
/* */
}

export default BookContextProvider