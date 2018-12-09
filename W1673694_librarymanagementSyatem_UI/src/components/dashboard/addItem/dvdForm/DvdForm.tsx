import axios from 'axios';
import * as React from 'react';
import { Button,Col, Form, FormGroup, Input, Label } from 'reactstrap';
import Swal from 'sweetalert2';
import './DvdForm.css';

interface IProps {
  props ?: any;
}

interface IState {
  isSubmitted ?: boolean;
  message ?: string;
}

class DvdForm extends React.Component <IProps,IState> {
  
  constructor(props:any) {
    super(props);
    this.handleFormSubmit = this.handleFormSubmit.bind(this);
    this.state = {
      isSubmitted:false,
      message:""
    }    
  }
  
  public handleFormSubmit = (e:any) => {
    e.preventDefault();
    this.setState({
      [e.target.name] : e.target.value 
    });
  }

  public handleSubmit = (event:any) => {

    event.preventDefault();
     axios.post('http://localhost:9000/library/dvd',
     {
       // @ts-ignore
       "ISBN": document.getElementById("dvdIsbn").value, 
       // @ts-ignore
       "title": document.getElementById("dvdTitle").value, 
       // @ts-ignore
       // tslint:disable-next-line:object-literal-sort-keys
       "sector": document.getElementById("dvdSector").value, 
       // @ts-ignore
       "publicationDate": document.getElementById("dvdDate").value, 
       // @ts-ignore
       "producer": document.getElementById("dvdProducer").value, 
       // @ts-ignore
       "actors": document.getElementById("dvdCast").value,
       // @ts-ignore 
       "avaLang": document.getElementById("dvdLanguage").value,
      // @ts-ignore 
      "avaSub": document.getElementById("dvdSubtitle").value,
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
    }).catch((err) => {
      // tslint:disable-next-line:no-console
      console.log(err.data);
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
      }).then(result => {
        if (result.value) {
          window.location.reload(true);
        }
      })
    });
 }
      
  public render() {
    return (
      <Form onSubmit={this.handleSubmit}>
          <FormGroup row={true}>
            <Label for='dvdIsbn'>ISBN : </Label>
            <Col sm='10'>
                <Input type='number' name='dvdIsbn' id='dvdIsbn' placeholder='ISBN goes here.'/>
            </Col>
          </FormGroup>
          <FormGroup row={true}>
            <Label for='dvdTitle'>Title : </Label>
            <Col sm='10'>
                <Input type='text' name='dvdTitle' id='dvdTitle' placeholder='Title of the DVD goes here.'/>
            </Col>
          </FormGroup>
          <FormGroup row={true}>
            <Label for='dvdSector'>Sector</Label>
            <Col sm='10'>
                <Input type="select" name="dvdSector" id="dvdSector">
                    <option>Database System</option>
                    <option>Machine Learning</option>
                    <option>AI</option>
                    <option>Java</option>
                    <option>JavaScript</option>
                </Input>
            </Col>
          </FormGroup>
          <FormGroup row={true}>
            <Label for='dvdDatePublished' >Date Published</Label>
            <Col sm='10'>
            <Input type="date" name="dvdDate" id="dvdDate" placeholder="DD-MM-YYYY" />
            </Col>
          </FormGroup>
          <FormGroup row={true}>
            <Label for='dvdProducer'>Producer </Label>
            <Col sm='10'>
                <Input type="text" name="dvdProducer" id="dvdProducer" placeholder="Producer goes here."/>
            </Col>
          </FormGroup>
          <FormGroup row={true}>
            <Label for='dvdLanguage'>Available Language </Label>
            <Col sm='10'>
                <Input type="text" name="dvdLanguage" id="dvdLanguage" placeholder="Type available language."/>
            </Col>
          </FormGroup>
          <FormGroup row={true}>
            <Label for='dvdSubtitle'>Subtitle(s)</Label>
            <Col sm='10'>
                <Input type="textarea" name="dvdSubtitle" id="dvdSubtitle" placeholder="Type available Subtitles separating by commas."/>
            </Col>
          </FormGroup>
          <FormGroup row={true}>
            <Label for='dvdCast'>Actor(s) or Actress(es) </Label>
            <Col sm='10'>
                <Input type="textarea" name="dvdCast" id="dvdCast" placeholder="Enter actor(s) and actress(es) separating by commas."/>
            </Col>
          </FormGroup>
          <Button type="submit">Add an Item</Button>
      </Form>
    )
  }
}

export default DvdForm;