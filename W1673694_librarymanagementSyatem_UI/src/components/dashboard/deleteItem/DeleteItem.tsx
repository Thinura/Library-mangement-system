import axios from 'axios';
import * as React from 'react';
import { Button, Col, Form, FormGroup, Input, Label, Row } from 'reactstrap';
import Swal from 'sweetalert2';
import './DeleteItem.css';

interface IState {
  activeTab?: string;
  isSubmitted?: boolean;
  message?: string;
  avaItem?: number;
  spaItem?: number;
}

interface IProps {
  props?: any;
}

export default class DeleteItem extends React.Component<IProps, IState> {

  constructor(props: any) {
    super(props);
    this.handleFormSubmit = this.handleFormSubmit.bind(this);
    this.toggle = this.toggle.bind(this);
    this.state = {
      activeTab: '1',
      isSubmitted: false,
      message: "",
      // tslint:disable-next-line:object-literal-sort-keys
      avaItem: 0,
      spaItem: 0
    };
  }

  public componentDidMount() {
    const URL = "http://localhost:9000/library/total";
    fetch(URL, {
      method: "GET"
    })
      .then(response => response.json())
      .then(total => {
        this.setState({
          isSubmitted: true,
          // tslint:disable-next-line:object-literal-sort-keys
          avaItem: total,
          spaItem: 150 - total
        })
      })
      .catch(err => {
        this.setState({
          isSubmitted: false,
          // tslint:disable-next-line:object-literal-sort-keys
          avaItem: 0,
          spaItem: 0
        })
      })
  }
  public toggle(tab: string) {
    if (this.state.activeTab !== tab) {
      this.setState({
        activeTab: tab
      });
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
    // @ts-ignore
    const isbn: string = document.getElementById("deleteItem").value;
    axios.delete('http://localhost:9000/library/delete/' + isbn)
      .then((res: any) => {
        this.setState({
          isSubmitted: true,
          message: res.data
        })
        if (res.data !== "ISBN number is wrong") {
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
      <div style={{ textAlign: 'center', alignItems: 'center', alignContent: 'center' }}>
        <Row>
          <Col sm="10" md={{ offset: 2 }}>
            <br />
            <Row>
              <ol>Available Items:</ol>
              <input style={{ width: '4%', marginTop: '0.2%', height: '5%', backgroundColor: '#CCE5FF', borderWidth: 0, textAlign: 'center' }} disabled={true} value={this.state.avaItem} />
              <ol>Space Left: </ol>
              <input style={{ width: '4%', marginTop: '0.2%', height: '5%', backgroundColor: '#CCE5FF', borderWidth: 0, textAlign: 'center' }} disabled={true} value={this.state.spaItem} />
            </Row>
          </Col>
        </Row>
        <Row>
          <Col sm="8" md={{ offset: 2 }}>
            <br />
            <Form onSubmit={this.handleSubmit}>
              <FormGroup row={true}>
                <Label for='deleteItem'>ISBN : </Label>
                <Col sm='10'>
                  <Input type='number' name='deleteItem' id='deleteItem' placeholder='ISBN goes here.' />
                </Col>
              </FormGroup>
              <Button type="submit">Delete an Item</Button>
            </Form>
            <br />
          </Col>
        </Row>
      </div>
    );
  }
}