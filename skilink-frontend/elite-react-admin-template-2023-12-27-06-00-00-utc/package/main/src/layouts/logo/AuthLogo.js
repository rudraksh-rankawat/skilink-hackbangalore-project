/*import React from 'react';
import { useSelector } from 'react-redux';

// import { ReactComponent as LogoDarkIcon } from '../../assets/images/logos/elite-dark-icon.svg';
// import LogoDarkText from '../../assets/images/logos/logo-text.png';
import { ReactComponent as LogoWhiteIcon } from '../../assets/images/logos/skilink_logo.svg';
import LogoWhiteText from '../../assets/images/logos/logo-light-text.png';

// const AuthLogo = () => {
//   const isDarkMode = useSelector((state) => state.customizer.isDark);

//   return (
//     <div className="p-4 d-flex justify-content-center gap-2">
//       {isDarkMode !== false ? (
//         <>
//           <LogoWhiteIcon />
//           <img src={LogoWhiteText} className="d-none d-lg-block" alt='logo-text' />
//         </>
//       ) : (
//         <>
//           <LogoDarkIcon />
//           <img src={LogoDarkText} className="d-none d-lg-block" alt='logo-text' />
//         </>
//       )}
//     </div>
//   );
// };

// export default AuthLogo;

const AuthLogo = () => {
  return (
    <div className="p-4 d-flex justify-content-center gap-2">
      <LogoWhiteIcon />
      <img src={LogoWhiteText} className="d-none d-lg-block" alt='logo-text' />
    </div>
  );
};

export default AuthLogo;
*/

import React from 'react';
//import { useSelector } from 'react-redux';
import { ReactComponent as LogoWhiteIcon } from '../../assets/images/logos/skilink_logo.svg'; // Assuming this is your Skilink logo SVG

const AuthLogo = () => {
  return (
    <div className="p-4 d-flex justify-content-center gap-2">
      <LogoWhiteIcon />
      <span className="d-none d-lg-block" style={{ fontFamily: 'Arial', fontSize: '40px', fontWeight: 'bold', color: '#000' }}>Skilink</span>
    </div>
  );
};

export default AuthLogo;
