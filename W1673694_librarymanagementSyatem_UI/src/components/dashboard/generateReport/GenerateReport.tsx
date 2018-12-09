import * as React from 'react';
import ReactTable from "react-table";
import 'react-table/react-table.css';
import './GenerateReport.css';

interface IProps {
    props?: any;
}

interface IState {
    overdueItems ?: []
}

class GenerateReport extends React.Component<IProps, IState> {
    public constructor(props: any) {
        super(props);
        this.state = {
            overdueItems: []
        }
    }

    public componentDidMount() {
        const URL = "http://localhost:9000/library/generateReport";
        fetch(URL, {
            method: "GET"
        })
            .then(response => response.json())
            .then(items => {
                this.setState({
                    overdueItems: items
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
                Header: 'Borrowed Date',
                accessor: 'borrowedDate'
            },
            {
                Header: 'Reader',
                accessor: 'borrowedReader.redName'
            },
            {
                Header: 'Fee',
                accessor: 'overdueFee'
            }
        ]
        return (
            <div>
                <ReactTable
                    columns={columns}
                    data={this.state.overdueItems}
                    showPagination={false}
                    style={{ textAlign: 'center' }} />
            </div>
        );
    }
}

export default GenerateReport;