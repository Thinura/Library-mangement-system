import axios from 'axios';
import * as React from 'react';
import { FaSearch } from 'react-icons/fa';
import {
    Route,
    Switch
} from 'react-router-dom';
import { Button, Input, InputGroup, InputGroupAddon } from 'reactstrap';
import {
    Col,
    Container,
    Nav,
    Navbar,
    NavbarBrand,
    NavItem,
    NavLink,
    Row
} from 'reactstrap';
import Footer from '../footer/Footer';
import AddItem from './addItem/AddItem';
import AddReader from './addReader/AddReader';
import BorrowItems from './borrowItem/BorrowItem';
import './Dashboard.css';
import DeleteItem from './deleteItem/DeleteItem';
import DisplayItems from './displayItems/DisplayItems';
import GenerateaReport from './generateReport/GenerateReport';
import ReturnItem from './returnItem/ReturnItem';
import SearchItem from './searchItem/searchItem';

interface IProps {
    Itemprops?: [];
}

interface IState {
    isSubmitted?: boolean;
    message?: string;
    Item?: [];
}

export default class Home extends React.Component<IProps, IState> {
    constructor(props: any) {
        super(props);
        this.handleSearchSubmit = this.handleSearchSubmit.bind(this);
        this.state = {
            isSubmitted: false,
            message: "",
            // tslint:disable-next-line:object-literal-sort-keys
            Item: []
        }
    }

    public handleSearchSubmit = (e: any) => {
        e.preventDefault();
        this.setState({
            [e.target.name]: e.target.value
        });
    }

    public handleSubmit = (event: any) => {
        event.preventDefault();
        // @ts-ignore
        const title: string = document.getElementById("searchBtn").value;
        axios.get('http://localhost:9000/library/search/' + title)
            .then((res: any) => res.json())
            .then(item => {
                this.setState({
                    Item: item
                })
            })
    }
    public render() {
        return (
            <Container className='Dashboard'>
                <Row>
                    <Navbar color='primary'>
                        <Col>
                            <NavbarBrand herf='/'>Westminster Library</NavbarBrand>
                        </Col>
                        <Col xs='4'>
                            <a href=''>
                                <InputGroup>
                                    <InputGroupAddon addonType="prepend" onClick={this.handleSubmit} ><Button><FaSearch /></Button></InputGroupAddon>
                                    <Input type="text" name="searchBtn" id="searchBtn" placeholder="Search by Title" />
                                </InputGroup>
                            </a>
                        </Col>
                    </Navbar>
                </Row>
                <Row style={{ padding: '2%' }}>
                    <Col xs='3'>
                        <Nav vertical={true}>
                            <NavItem>
                                <NavLink href="/addReader">Add a Reader</NavLink>
                                <NavLink href="/addItem">Add a new Item</NavLink>
                                <NavLink href="/deleteItem" >Delete an Item</NavLink>
                                <NavLink href="/displayItems" >Display the list of the items</NavLink>
                                <NavLink href="/borrowItem" >Borrow an item</NavLink>
                                <NavLink href="/returnItem" >Return an item</NavLink>
                                <NavLink href="/generateReport" >Generate a report</NavLink>
                            </NavItem>
                        </Nav>
                    </Col>
                    <Col xs='9' style={{ backgroundColor: '#CCE5FF' }}>
                        {/* <SearchItem searchItem={this.state.Item}/> */}
                        <Switch>
                            <Route path="/searchItem" component={SearchItem} />
                            <Route path='/addReader' component={AddReader} />
                            <Route path='/addItem' component={AddItem} />
                            <Route path='/deleteItem' component={DeleteItem} />
                            <Route path='/displayItems' component={DisplayItems} />
                            <Route path='/borrowItem' component={BorrowItems} />
                            <Route path='/returnItem' component={ReturnItem} />
                            <Route path='/generateReport' component={GenerateaReport} />
                        </Switch>
                    </Col>
                </Row>
                <Row><Footer /></Row>
            </Container>
        )
    }
}
