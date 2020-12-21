import React from 'react';
import '../assets/css/Page.css';
import { Link } from 'react-router-dom';

export default class PossuiCadastro extends React.Component {
  render() {
    return (
      <>
        <Link to={this.props.toLogin}>
          <span>Já possui conta e quer voltar ao Login?</span>
        </Link>
        <br />
        <br />
      </>
    )
  }
}