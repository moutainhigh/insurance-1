import React, { PropTypes } from 'react';
import { Router, Route, IndexRoute, Link, hashHistory } from 'react-router';
import NotFound from 'components/common/NotFound';
import LoanList from 'components/loan/LoanList'
import CustomerList from 'components/customer/CustomerList'
import DealerUserList from 'components/usermanage/DealerUserList'
import DashboardIndex from '../components/dashboard/DashboardIndex';
const Routes = () =>
  <Router history={hashHistory}>
    <Route path="/" component={LoanList} />
    <Route path="/dashboard" component={DashboardIndex} />
    <Route path="/loanlist" component={LoanList}/>
    <Route path="/customerlist" component={CustomerList}/>
    <Route path="/dealeruserlist" component={DealerUserList}/>
    <Route path="*" component={NotFound}/>
  </Router>;

Routes.propTypes = {
  history: PropTypes.any,
};

export default Routes;
