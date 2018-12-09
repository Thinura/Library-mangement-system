import axios from 'axios';
import * as React from 'react';
import "react-datepicker/dist/react-datepicker.css";
import { Button, Col, Form, FormGroup, Input, Label } from 'reactstrap';
import Swal from 'sweetalert2';
import './ReturnItem.css';

interface IProps {
    props?: any;
}

interface IState {
    isSubmitted?: boolean;
    message?: string;
}

class ReturnItem extends React.Component<IProps, IState> {

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
        axios.post('http://localhost:9000/library/return',
            {
                // @ts-ignore
                "isbn": document.getElementById("returnIsbn").value,
                // @ts-ignore
                "reader": document.getElementById("returnReader").value,
                // @ts-ignore
                // tslint:disable-next-line:object-literal-sort-keys
                "dateReturned": document.getElementById("returnDate").value,
            })
            .then((res: any) => {
                this.setState({
                    isSubmitted: true,
                    message: res.data
                })
                if ((res.data === "Successfully returned the DVD.") || (res.data === "Successfully returned the Book.")) {
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
                        <Label for='returnReader'>Name : </Label>
                        <Col sm='8'>
                            <Input type='text' name='returnReader' id='returnReader' placeholder='Name of the reader.' />
                        </Col>
                    </FormGroup>
                    <FormGroup row={true}>
                        <Label for='returnIsbn'>ISBN : </Label>
                        <Col sm='8'>
                            <Input type='number' name='returnIsbn' id='returnIsbn' placeholder='ISBN goes here.' />
                        </Col>
                    </FormGroup>
                    <FormGroup row={true}>
                        <Label for='returnDate' >Returned Date :</Label>
                        <Col sm='5'>
                            <Input type="datetime-local" name="retirnDate" id="returnDate" placeholder="DD-MM-YYYY" />
                        </Col>
                    </FormGroup>
                    <Button type="submit">Returned</Button>
                </Form>
                <br />
            </Col>
        );
    }
}

export default ReturnItem;