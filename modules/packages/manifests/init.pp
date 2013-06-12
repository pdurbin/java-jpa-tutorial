class packages {

  $packages_to_install = [
    'java-1.6.0-openjdk',
    'java-1.6.0-openjdk-devel',
    #"We aren't quite ready to build the samples with Java 7 yet" -- http://mail-archives.apache.org/mod_mbox/openjpa-dev/201107.mbox/%3CCAGNTB4QrSrHuh1P5rSv7C2Rqj+4Den9iNqd3_pwxfi2A9VP0gA@mail.gmail.com%3E
    #'java-1.7.0-openjdk',
    #'java-1.7.0-openjdk-devel',
    'unzip',
    'git',
    'ant',
    'apache-maven',
    'vim-enhanced',
  ]

  package { $packages_to_install:
    ensure => installed,
  }

}
