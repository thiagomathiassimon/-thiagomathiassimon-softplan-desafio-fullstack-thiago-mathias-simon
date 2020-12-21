import React from 'react';
import { BrowserRouter, Switch, Route, Redirect } from 'react-router-dom';
import { isAutenticated } from '../services/auth';
import Processo from '../pages/Processo';
import LoginAdministrador from '../pages/LoginAdministrador';
import LoginTriador from '../pages/LoginTriador';
import LoginFinalizador from '../pages/LoginFinalizador';
import CadastroAdministrador from '../pages/CadastroAdministrador';
import CadastroTriador from '../pages/CadastroTriador';
import CadastroFinalizador from '../pages/CadastroFinalizador';
import IncluirProcesso from '../pages/IncluirProcesso';
import VizualizarProcessos from '../pages/VizualizarProcessos';
import PaginaInicial from '../pages/PaginaInicial';

const PrivateRoute = ({ component: Component, ...rest }) => (
  <Route {...rest} render={props => (
    isAutenticated() ? (
      <Component {...props} />
    ) : (
        <Redirect to={{ pathname: '/paginainicial', state: { from: props.lacation } }} />
      )
  )} />
)

const Routes = () => (
  <BrowserRouter>
    <Switch>
      <Route path='/paginainicial' component={PaginaInicial} />
      <Route path='/loginadministrador' component={LoginAdministrador} />
      <Route path='/logintriador' component={LoginTriador} />
      <Route path='/loginfinalizador' component={LoginFinalizador} />
      <Route path='/cadastroadministrador' component={CadastroAdministrador} />
      <Route path='/cadastrotriador' component={CadastroTriador} />
      <Route path='/cadastrofinalizador' component={CadastroFinalizador} />
      <PrivateRoute exact path='/' component={Processo} />
      <PrivateRoute path='/incluirprocesso' component={IncluirProcesso} />
      <PrivateRoute path='/visualizarprocessos' component={VizualizarProcessos} />
    </Switch>
  </BrowserRouter>
)

export default Routes;