import React, { PropTypes } from 'react';
import { Router, Route, IndexRoute, Link, hashHistory } from 'react-router';
import NotFound from 'components/common/NotFound';
import LoanList from 'components/loan/LoanList'
// import Repayment from 'components/repayment/RepaymentList'
import Dealer from 'components/dealer/Dealer'
import DealerUserList from 'components/usermanage/DealerUserList'
const Routes = () =>
  <Router history={hashHistory}>
    <Route path="/" component={Dealer} />
    <Route path="/dealer" component={Dealer} />
    <Route path="/loan" component={LoanList}/>
    {/*<Route path="/repayment" component={repayment}/>*/}
    <Route path="/adminUser" component={DealerUserList}/>
    <Route path="*" component={NotFound}/>
  </Router>;

Routes.propTypes = {
  history: PropTypes.any,
};

export default Routes;
