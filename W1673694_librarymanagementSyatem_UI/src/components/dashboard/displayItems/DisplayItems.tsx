import * as React from 'react';
import ReactTable from "react-table";
import 'react-table/react-table.css';
import './DisplayItems.css';

interface IProps {
    props?: any;
}

interface IState {
    message?: string,
    Items?: []
}

class DisplayItems extends React.Component<IProps, IState>{
    public constructor(props: any) {
        super(props);
        this.state = {
            Items: []
        }
    }

    public componentDidMount() {
        const URL = "http://localhost:9000/library/display";
        fetch(URL, {
            method: "GET"
        })
            .then(response => response.json())
            .then(items => {
                this.setState({
                    Items: items
                })
            })
            .catch(err => {
                this.setState({
                    message:err.data
                })
            })
    }

    public render() {
        const columns = [
            {
                Header: 'Number of Items',
                filterable: false,
                // tslint:disable-next-line:object-literal-sort-keys
                Cell: (row: any) => {
                    return <div>{row.index + 1}</div>;
                }
            },
            {
                Header: 'ISBN',
                accessor: 'isbn'
            },
            {
                Header: 'Type',
                accessor: 'type'
            },
            {
                Header: 'Title',
                accessor: 'title'
            },
            {
                Header: 'Sector',
                accessor: 'sector'
            },
            {
                Header: 'Status',
                accessor: 'borrowedReader',
                // tslint:disable-next-line:object-literal-sort-keys
                Cell: (row: any) => {
                    return(<span>
                        <span style={{
                            color: row.value == null ? '#00CC00'
                                    : '#E93939',
                            transition: 'all .3s ease'
                        }}>
                            &#x25cf;
                        </span> {
                            row.value == null ? 'Available'
                                    : 'Borrowed'
                        }
                    </span>);

                }
            }
        ]
        return (
            <div>
                <ReactTable
                    columns={columns}
                    data={this.state.Items}
                    showPagination={false}
                    style={{ textAlign: 'center' }} />
            </div>
        );
    }
}
export default DisplayItems;