import axios from 'axios';
import * as React from 'react';
import { Button, Col, Form, FormGroup, Input, Label } from 'reactstrap';
import Swal from 'sweetalert2';
import './AddReader.css';

interface IProps {
  props?: any;
}

interface IState {
  isSubmitted?: boolean;
  message?: string;
}

class AddReader extends React.Component<IProps, IState> {

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
    axios.post('http://localhost:9000/library/reader',
      {
        // @ts-ignore
        "redId": document.getElementById("redId").value,
        // @ts-ignore
        "redName": document.getElementById("redName").value,
        // @ts-ignore
        // tslint:disable-next-line:object-literal-sort-keys
        "redMobileNum": document.getElementById("redMobileNum").value,
        // @ts-ignore
        "redEmail": document.getElementById("redEmail").value,
      })
      .then((res: any) => {
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
          })
            .then(result => {
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
          })
            .then(result => {
              if (result.value) {
                window.location.reload(true);
              }
            })
        }
      })
      .catch((err) => {
        this.setState({
          isSubmitted: false,
          message: err.data
        })
        Swal({
          title: 'Error',
          // tslint:disable-next-line:object-literal-sort-keys
          text: 'Error occurred',
          type: 'warning',
          confirmButtonText: 'ok'
        })
          .then(result => {
            if (result.value) {
              window.location.reload(true);
            }
          })
      });
  }

  public render() {
    return (
      <Col sm='12' md={{ offset: 2 }}>
        <br />
        <Form onSubmit={this.handleSubmit}>
          <FormGroup row={true}>
            <Label for='redId'>Reader Id : </Label>
            <Col sm='8'>
              <Input type='number' name='redId' id='redId' placeholder='Reader Id goes here.' />
            </Col>
          </FormGroup>
          <FormGroup row={true}>
            <Label for='redName'>Name : </Label>
            <Col sm='8'>
              <Input type='text' name='redName' id='redName' placeholder='Name goes here.' />
            </Col>
          </FormGroup>
          <FormGroup row={true}>
            <Label for='redMobileNum'>Mobile number : </Label>
            <Col sm='8'>
              <Input type='number' name='redMobileNum' id='redMobileNum' placeholder='Mobile number goes here.' />
            </Col>
          </FormGroup>
          <FormGroup row={true}>
            <Label for='redEmail'>Mobile number : </Label>
            <Col sm='8'>
              <Input type='email' name='redEmail' id='redEmail' placeholder='Email goes here.' />
            </Col>
          </FormGroup>
          <Button type="submit">Add Read</Button>
        </Form>
        <br />
      </Col>
    );
  }
}
export default AddReader;