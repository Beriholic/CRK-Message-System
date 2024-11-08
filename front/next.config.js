const rewrites = async () => {
  return [
    {
      source: "/api/:path*",
      destination: "http://localhost:8080/:path*",
    },
  ];
};
const nextConfig = {
  rewrites,
};

export default nextConfig;
