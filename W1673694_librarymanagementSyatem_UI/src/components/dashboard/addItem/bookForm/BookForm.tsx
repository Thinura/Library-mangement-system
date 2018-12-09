import axios from 'axios';
import * as React from 'react';
import { Button, Col, Form, FormGroup, Input, Label } from 'reactstrap';
import Swal from 'sweetalert2';
import './BookForm.css';

interface IProps {
  props?: any;
}

interface IState {
  isSubmitted?: boolean;
  message?: string;
}

class BookForm extends React.Component<IProps, IState> {

  constructor(props: any) {
    super(props);
    this.handleFormSubmit = this.handleFormSubmit.bind(this);
    this.state = {
      isSubmitted: false,
      message: ""
    }
  }

  public handleFormSubmit = (e: any) => {
    e.preventDefault();
    this.setState({
      [e.target.name]: e.target.value
    });
  }

  public handleSubmit = (event: any) => {

    event.preventDefault();
    axios.post('http://localhost:9000/library/book',
      {
        // @ts-ignore
        "ISBN": document.getElementById("bookIsbn").value,
        // @ts-ignore
        "title": document.getElementById("bookTitle").value,
        // @ts-ignore
        // tslint:disable-next-line:object-literal-sort-keys
        "sector": document.getElementById("bookSector").value,
        // @ts-ignore
        "publicationDate": document.getElementById("bookDate").value,
        // @ts-ignore
        "authName": document.getElementById("bookAuthor").value,
        // @ts-ignore
        "pubComName": document.getElementById("bookPublisher").value,
        // @ts-ignore 
        "pages": document.getElementById("bookPageCount").value
      }).then((res: any) => {
        this.setState({
          isSubmitted: true,
          message: res.data
        })
        if (res.data === "Successfully added to the library.") {
          Swal({
            title: 'Success',
            // tslint:disable-next-line:object-literal-sort-keys
            text: res.data,
            type: 'success',
            confirmButtonText: 'ok'
          }).then(result => {
            if (result.value) {
              window.location.reload(true);
            }
          })
        } else {
          Swal({
            title: 'Warning',
            // tslint:disable-next-line:object-literal-sort-keys
            text: res.data,
            type: 'warning',
            confirmButtonText: 'ok'
          }).then(result => {
            if (result.value) {
              window.location.reload(true);
            }
          })
        }
      }).catch(err => {
        this.setState({
          isSubmitted: false,
          message: err.data
        })
      });
  }

  public render() {
    return (
      <Form onSubmit={this.handleSubmit}>
        <FormGroup row={true}>
          <Label for='bookIsbn'>ISBN : </Label>
          <Col sm='10'>
            <Input type='number' name='bookIsbn' id='bookIsbn' placeholder='ISBN goes here.' />
          </Col>
        </FormGroup>
        <FormGroup row={true}>
          <Label for='bookTitle'>Title : </Label>
          <Col sm='10'>
            <Input type='text' name='bookTitle' id='bookTitle' placeholder='Title of the book goes here.' />
          </Col>
        </FormGroup>
        <FormGroup row={true}>
          <Label for='bookSector'>Sector</Label>
          <Col sm='10'>
            <Input type="select" name="bookSector" id="bookSector" >
              <option>Database System</option>
              <option>Machine Learning</option>
              <option>AI</option>
              <option>Java</option>
              <option>JavaScript</option>
            </Input>
          </Col>
        </FormGroup>
        <FormGroup row={true}>
          <Label for='bookDatePublished'>Date Published</Label>
          <Col sm='10'>
            <Input type="date" name="bookDate" id="bookDate" placeholder="DD-MM-YYYY" />
          </Col>
        </FormGroup>
        <FormGroup row={true}>
          <Label for='bookAuthor'>Author(s)</Label>
          <Col sm='10'>
            <Input type="textarea" name="bookAuthor" id="bookAuthor" placeholder="Separate authors by commas." />
          </Col>
        </FormGroup>
        <FormGroup row={true}>
          <Label for='bookPublisher'>Publisher : </Label>
          <Col sm='10'>
            <Input type='text' name='bookPublisher' id='bookPublisher' placeholder='Publisher of the book.' />
          </Col>
        </FormGroup>
        <FormGroup row={true}>
          <Label for='bookPageCount'>Page count : </Label>
          <Col sm='10'>
            <Input type='number' name='bookPageCount' id='bookPageCount' placeholder='Number of pages in the book.' />
          </Col>
        </FormGroup>
        <Button type="submit">Add Item</Button>
      </Form>
    )
  }
}

export default BookForm;