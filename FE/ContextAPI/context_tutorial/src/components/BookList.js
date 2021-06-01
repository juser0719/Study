import React, {useContext} from 'react';
import { BookContext } from '../contexts/BookContext';
import { ThemeContext } from '../contexts/ThemeContext';
import BookDetails from './BookDetails';

function BookList () { 
  const {isLightTheme , light, dark} = useContext(ThemeContext)
  const { books } = useContext(BookContext)
  const theme = isLightTheme ? light : dark;

    return books.length ? ( 
      <div className="book-list" style={{color : theme.syntax, background : theme.bg}}>
        <ul>
          {books.map(book =>{
            return(
              <BookDetails book={book} key = {book.id}/>    
            )
          })}
        </ul>
      </div>
    ) : (
      <div className ="empty">
          No books to read. Hello free time :) 
      </div>
    );
}
 
export default BookList;