import React , {useContext }from 'react'
import { BookContext } from '../contexts/BookContext'

function BookDetails ({book}) {
    const {removeBook} = useContext(BookContext)

    return(
    <li onClick ={() => removeBook(book.id)}>
        <div className ="title"><h4> - {book.title}</h4></div>
        <div className ="author">{book.author}</div>
    </li>)
}

export default BookDetails