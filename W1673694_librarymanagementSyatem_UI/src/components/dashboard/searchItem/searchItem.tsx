import * as React from 'react';
import './searchItem.css';

interface IProps {
    Items?: []
}

interface IState {
    message?: string,
}

export default class SearchItem extends React.Component<IProps, IState> {
  public render() {
    return (
        <div style={{ textAlign: 'center', alignItems: 'center', alignContent: 'center' }}>
            {}
        </div>
    )
  }
}
