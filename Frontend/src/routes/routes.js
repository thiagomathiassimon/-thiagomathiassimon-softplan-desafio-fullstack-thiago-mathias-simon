import React from 'react';
import { BrowserRouter, Switch, Route, Redirect } from 'react-router-dom';
import { isAutenticated } from '../services/auth';
import Processo from '../pages/Processo';
import Login from '../pages/Login';
import Cadastro from '../pages/Cadastro';
import IncluirProcesso from '../pages/IncluirProcesso';
import VizualizarProcessos from '../pages/VizualizarProcessos';

const PrivateRoute = ({ component: Component, ...rest }) => (
  <Route {...rest} render={props => (
    isAutenticated() ? (
      <Component {...props} />
    ) : (
        <Redirect to={{ pathname: '/login', state: { from: props.lacation } }} />
      )
  )} />
)

const Routes = () => (
  <BrowserRouter>
    <Switch>
      <Route path='/login' component={Login} />
      <Route path='/cadastro' component={Cadastro} />
      <PrivateRoute exact path='/' component={Processo} />
      <PrivateRoute path='/incluirprocesso' component={IncluirProcesso} />
      <PrivateRoute path='/visualizarprocessos' component={VizualizarProcessos} />
    </Switch>
  </BrowserRouter>
)

export default Routes;