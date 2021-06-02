import React, {createContext, useState , useReducer} from 'react'
import uuid from 'uuid/v1'
import { bookReducer } from '../reducers/bookReducer';

export const BookContext = createContext();

function BookContextProvider(props) {
    const [books, dispatch] = useReducer(bookReducer,[]);

    // const [books, setBooks] = useState([
    //     {title: 'name of the wind', author:'patrick rothfuss',id: 1},
    //     {title: 'the way of kings', author:'brandon sanderson', id: 2},
    // ])

    // const addBook = (title,author) =>{
    //     setBooks([...books,{title,author, id: uuid() }])
    // }

    // const removeBook = (id) =>{
    //     setBooks(books.filter(book => book.id !== id))
    // }

    return(
        <BookContext.Provider value ={{books, dispatch}}>
            {props.children}
        </BookContext.Provider>
    )
}

export default BookContextProvider