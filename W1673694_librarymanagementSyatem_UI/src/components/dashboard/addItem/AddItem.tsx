import classnames from 'classnames';
import * as React from 'react';
import { Col, Nav, NavItem, NavLink, Row, TabContent, TabPane } from 'reactstrap';
import './AddItem.css';
import BookForm from './bookForm/BookForm';
import DvdForm from './dvdForm/DvdForm';

interface IState {
    activeTab?: string;
    totalItem?: number;
}

interface IProps {
    props: string;
}

class AddItem extends React.Component<IProps, IState> {
    constructor(props: any) {
        super(props);
        this.toggle = this.toggle.bind(this);
        this.state = {
            activeTab: '1',
            totalItem: 0
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
                    totalItem: total
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

    public render() {
        return (
            <div style={{ textAlign: 'center', alignItems: 'center', alignContent: 'center' }}>
                <Row>
                    <Col sm="10" md={{ offset: 4 }}>
                        <br />
                        <Row>
                            <ol>Total Items:</ol>
                            <input disabled={true} style={{ width: '4%', marginTop: '0.2%', height: '5%', backgroundColor: '#CCE5FF', borderWidth: 0, textAlign: 'center' }} value={this.state.totalItem} />
                        </Row>
                    </Col>
                </Row>
                <Row>
                    <Nav tabs={true} style={{ width: '100%' }}>
                        <NavItem style={{ width: '50%' }}>
                            <NavLink
                                className={classnames({ active: this.state.activeTab === '1' })}
                                // tslint:disable-next-line:jsx-no-lambda
                                onClick={() => { this.toggle('1'); }}
                            >
                                Book
                        </NavLink>
                        </NavItem>
                        <NavItem style={{ width: '50%' }}>
                            <NavLink
                                className={classnames({ active: this.state.activeTab === '2' })}
                                // tslint:disable-next-line:jsx-no-lambda
                                onClick={() => { this.toggle('2'); }}
                            >
                                DVD
                        </NavLink>
                        </NavItem>
                    </Nav>
                    <TabContent activeTab={this.state.activeTab}>
                        <TabPane tabId="1">
                            <Row>
                                <Col sm="12" md={{ offset: 8 }}>
                                    <br /><br />
                                    <BookForm />
                                    <br />
                                </Col>
                            </Row>
                        </TabPane>
                        <TabPane tabId="2">
                            <Row>
                                <Col sm="12" md={{ offset: 8 }}>
                                    <br /><br />
                                    <DvdForm />
                                    <br />
                                </Col>
                            </Row>
                        </TabPane>
                    </TabContent>
                </Row>
            </div>
        );
    }
}

export default AddItem;