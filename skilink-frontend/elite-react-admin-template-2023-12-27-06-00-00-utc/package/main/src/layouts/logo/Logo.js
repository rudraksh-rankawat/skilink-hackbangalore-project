// import { useSelector } from 'react-redux';
// import { Link } from 'react-router-dom';
// import React from 'react';
// import { ReactComponent as LogoDarkIcon } from '../../assets/images/logos/elite-dark-icon.svg';
// import LogoDarkText from '../../assets/images/logos/logo-text.png';
// import { ReactComponent as LogoWhiteIcon } from '../../assets/images/logos/elite-white-icon.svg';
// import LogoWhiteText  from '../../assets/images/logos/logo-light-text.png';

// const Logo = () => {
//   const isDarkMode = useSelector((state) => state.customizer.isDark);
//   const toggleMiniSidebar = useSelector((state) => state.customizer.isMiniSidebar);
//   const activeSidebarBg = useSelector((state) => state.customizer.sidebarBg);
//   return (
//     <Link to="/" className="d-flex align-items-center gap-2">
//       {isDarkMode || activeSidebarBg !== 'white' ? (
//         <>
//           <LogoWhiteIcon />
//           {toggleMiniSidebar ? '' : <img src={LogoWhiteText} className="d-none d-lg-block" alt='logo-text' />}
//         </>
//       ) : (
//         <>
//           <LogoDarkIcon />
//           {toggleMiniSidebar ? '' : <img src={LogoDarkText} className="d-none d-lg-block" alt='logo-text' />}
//         </>
//       )}
//     </Link>
//   );
// };

// export default Logo;


import React from 'react';
import { useSelector } from 'react-redux';
import { Link } from 'react-router-dom';

const Logo = () => {
  const isDarkMode = useSelector((state) => state.customizer.isDark);
  //const toggleMiniSidebar = useSelector((state) => state.customizer.isMiniSidebar);
  const activeSidebarBg = useSelector((state) => state.customizer.sidebarBg);

  const logoStyle = {
    fontSize: '100px', // Adjust font size as needed
    fontWeight: 'bold', // Adjust font weight as needed
    color: isDarkMode || activeSidebarBg !== 'white' ? '#ffffff' : '#000000', // Change color based on mode
  };

  return (
    <Link to="/auth/loginformik" className="d-flex align-items-center gap-2" style={logoStyle}>
      Skilink.
    </Link>
  );
};

export default Logo;
