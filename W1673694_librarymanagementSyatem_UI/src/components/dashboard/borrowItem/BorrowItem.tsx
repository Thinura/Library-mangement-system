import axios from 'axios';
import * as React from 'react';
import { Button, Col, Form, FormGroup, Input, Label } from 'reactstrap';
import Swal from 'sweetalert2';
import './BorrowItem.css';

interface IProps {
  props?: any;
}

interface IState {
  isSubmitted?: boolean;
  message?: string;
}

class BorrowItem extends React.Component<IProps, IState> {

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
    axios.post('http://localhost:9000/library/borrow',
      {
        // @ts-ignore
        "isbn": document.getElementById("borrowIsbn").value,
        // @ts-ignore
        "reader": document.getElementById("borrowReader").value,
        // @ts-ignore
        // tslint:disable-next-line:object-literal-sort-keys
        "dateBorrowed": document.getElementById("borrowDate").value,
      })
      .then((res: any) => {
        this.setState({
          isSubmitted: true,
          message: res.data
        })
        if ((res.data === "Successfully borrowed the Book.") || (res.data === "Successfully borrowed the DVD.")) {
          Swal({
            title: 'Success',
            // tslint:disable-next-line:object-literal-sort-keys
            text: res.data,
            type: 'success',
            confirmButtonText: 'ok'
          })
            .then(result => {
              if (result.value) { window.location.reload(true); }
            })
        } else {
          Swal({
            title: 'Warning',
            // tslint:disable-next-line:object-literal-sort-keys
            text: res.data,
            type: 'warning',
            confirmButtonText: 'ok'
          })
            .then(result => {
              if (result.value) { window.location.reload(true); }
            })
        }
      })
      .catch(err => {
        this.setState({
          isSubmitted: false,
          message: err.data
        })
      });
  }

  public render() {
    return (
      <Col sm='12' md={{ offset: 2 }}>
        <br />
        <Form onSubmit={this.handleSubmit}>
          <FormGroup row={true}>
            <Label for='borrowReader'>Name : </Label>
            <Col sm='8'>
              <Input type='text' name='borrowReader' id='borrowReader' placeholder='Name of the reader.' />
            </Col>
          </FormGroup>
          <FormGroup row={true}>
            <Label for='borrowIsbn'>ISBN : </Label>
            <Col sm='8'>
              <Input type='number' name='borrowIsbn' id='borrowIsbn' placeholder='ISBN goes here.' />
            </Col>
          </FormGroup>
          <FormGroup row={true}>
            <Label for='borrowDate' >Borrowed Date :</Label>
            <Col sm='5'>
              <Input type="datetime-local" name="borrowDate" id="borrowDate" placeholder="DD-MM-YYYY" />
            </Col>
          </FormGroup>
          <Button type="submit">Borrowed</Button>
        </Form>
        <br />
      </Col>
    );
  }
}

export default BorrowItem;